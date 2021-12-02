package me.mcblueparrot.spade.launcher;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.launch.platform.IMixinPlatformAgent;
import org.spongepowered.asm.launch.platform.MixinPlatformManager;
import org.spongepowered.asm.launch.platform.container.IContainerHandle;
import org.spongepowered.asm.service.IClassBytecodeProvider;
import org.spongepowered.asm.service.IClassProvider;
import org.spongepowered.asm.service.IClassTracker;
import org.spongepowered.asm.service.IMixinAuditTrail;
import org.spongepowered.asm.service.ITransformer;
import org.spongepowered.asm.service.ITransformerProvider;
import org.spongepowered.asm.service.MixinServiceAbstract;

import com.google.common.collect.ImmutableList;

/**
 * @deprecated Unused
 */
// TODO Delete
@Deprecated
public class SpadeMixinService extends MixinServiceAbstract implements IClassProvider, IClassBytecodeProvider, ITransformerProvider, IClassTracker, IMixinPlatformAgent {

	private final ClassLoader CLASS_LOADER = SpadeLauncher.class.getClassLoader();
	private Set<String> invalidClasses = new HashSet<String>();
	private Set<String> cachedClasses = new HashSet<String>();

	@Override
	public String getName() {
		return "spade";
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public IClassProvider getClassProvider() {
		return this;
	}

	@Override
	public IClassBytecodeProvider getBytecodeProvider() {
		return this;
	}

	@Override
	public ITransformerProvider getTransformerProvider() {
		return this;
	}

	@Override
	public IClassTracker getClassTracker() {
		return this;
	}

	@Override
	public IMixinAuditTrail getAuditTrail() {
		return null;
	}

	@Override
	public Collection<String> getPlatformAgents() {
		return ImmutableList.of(
			getClass().getName()
		);
	}

	@Override
	public IContainerHandle getPrimaryContainer() {
		return null;
	}

	@Override
	public InputStream getResourceAsStream(String name) {
		return null;
	}

	@Override
	public URL[] getClassPath() {
		return null;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		return Class.forName(name);
	}

	@Override
	public Class<?> findClass(String name, boolean initialize) throws ClassNotFoundException {
		return Class.forName(name, initialize, CLASS_LOADER);
	}

	@Override
	public Class<?> findAgentClass(String name, boolean initialize) throws ClassNotFoundException {
		return Class.forName(name, initialize, CLASS_LOADER);
	}

	@Override
	public void registerInvalidClass(String className) {
		invalidClasses.add(className);
	}

	@Override
	public boolean isClassLoaded(String className) {
		return cachedClasses.contains(className);
	}

	@Override
	public String getClassRestrictions(String className) {
		return null;
	}

	@Override
	public Collection<ITransformer> getTransformers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ITransformer> getDelegatedTransformers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTransformerExclusion(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public ClassNode getClassNode(String name) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassNode getClassNode(String name, boolean runTransformers) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AcceptResult accept(MixinPlatformManager manager, IContainerHandle handle) {
		return AcceptResult.ACCEPTED;
	}

	@Override
	public String getPhaseProvider() {
		return null;
	}

	@Override
	public void initPrimaryContainer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inject() {
		// TODO Auto-generated method stub

	}

}
