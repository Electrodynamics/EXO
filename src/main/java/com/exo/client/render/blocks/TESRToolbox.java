package com.exo.client.render.blocks;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import com.exo.client.render.IModel;
import com.exo.client.render.model.ModelToolbox;
import com.exo.lib.helpers.RenderHelper;
import com.exo.lib.helpers.RotationHelper;
import com.exo.lib.vector.Vector3;

import cpw.mods.fml.client.FMLClientHandler;

public final class TESRToolbox extends TileEntitySpecialRenderer{
	private final IModel MODEL = new ModelToolbox();
	private final ResourceLocation TEXTURE = new ResourceLocation("exo", "textures/blocks/toolbox.png");
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partial) {
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.TEXTURE);
		glPushMatrix();
		glEnable(GL_LIGHTING);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		RenderHelper.INSTANCE.translate(RenderHelper.INSTANCE.createBasicOffset(Vector3.of((float) x, (float) y, (float) z)));
		RotationHelper.INSTANCE.rotate(180.0F, RotationHelper.X_MAG);
		this.MODEL.render();
		glDisable(GL_BLEND);
		glDisable(GL_LIGHTING);
		glPopMatrix();
	}
}