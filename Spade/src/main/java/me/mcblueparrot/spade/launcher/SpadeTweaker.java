package me.mcblueparrot.spade.launcher;

import java.io.File;
import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import me.mcblueparrot.spade.main.Main;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

public class SpadeTweaker implements ITweaker, IClassTransformer {

	@Override
	public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {}

	@Override
	public void injectIntoClassLoader(LaunchClassLoader classLoader) {
		classLoader.registerTransformer(getClass().getName());
	}

	@Override
	public String getLaunchTarget() {
		return Main.class.getName();
	}

	@Override
	public String[] getLaunchArguments() {
		return SpadeLauncher.args;
	}

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		AccessChanger chosenAccessChanger = null;
		for(AccessChanger testAcessChanger : AccessChanger.accessChangers) {
			if(testAcessChanger.getTargetClass().getName().equals(name)) {
				chosenAccessChanger = testAcessChanger;
			}
		}

		if(chosenAccessChanger == null) {
			return basicClass;
		}

		AccessChanger accessChanger = chosenAccessChanger;

		ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
		ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM5, classWriter) {

			@Override
			public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
				return super.visitField(accessChanger.applyField(name, access), name, desc, signature, value);
			}

			@Override
			public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
				return super.visitMethod(accessChanger.applyMethod(name, signature, access), name, desc, signature, exceptions);
			}

		};
		ClassReader classReader = new ClassReader(basicClass);
		classReader.accept(classVisitor, 0);
		return classWriter.toByteArray();
	}

}
