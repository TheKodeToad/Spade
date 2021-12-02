package me.mcblueparrot.spade.mixin;

import java.net.Proxy;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;

import me.mcblueparrot.spade.Spade;
import me.mcblueparrot.spade.vanilla.VanillaServer;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ServerResourceManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListenerFactory;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import net.minecraft.util.UserCache;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.level.storage.LevelStorage;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

	@Inject(at = @At("RETURN"), method = "<init>")
	public void init(Thread thread, DynamicRegistryManager.Impl dynamicRegistryManager, LevelStorage.Session session, SaveProperties saveProperties, ResourcePackManager resourcePackManager, Proxy proxy, DataFixer dataFixer, ServerResourceManager serverResourceManager, MinecraftSessionService minecraftSessionService, GameProfileRepository gameProfileRepository, UserCache userCache, WorldGenerationProgressListenerFactory worldGenerationProgressListenerFactory, CallbackInfo callback) {
		MinecraftServer minecraftServer = (MinecraftServer) (Object) this;
		if(minecraftServer instanceof MinecraftDedicatedServer) {
			VanillaServer server = new VanillaServer((MinecraftDedicatedServer) minecraftServer);
			Spade.trySetServer(server);
			server.init();
		}
	}

	@Inject(at = @At("RETURN"), method = "loadWorld")
	public void loadWorld(CallbackInfo callback) {
		Spade.getPluginManager().enable();
	}

	@Inject(at = @At("HEAD"), method = "shutdown")
	public void shutdown(CallbackInfo callback) {
		Spade.getPluginManager().disable();
	}

	@Inject(at = @At("HEAD"), method = "getServerModName", cancellable = true)
	public void getServerModName(CallbackInfoReturnable<String> callback) {
		callback.setReturnValue("Spade " + Spade.getVersion().getId());
	}

}
