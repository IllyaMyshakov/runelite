/*
 * Copyright (c) 2020, Illya Myshakov <https://github.com/IllyaMyshakov>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.mahoganyhomes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.NullObjectID;
import net.runelite.api.Skill;
import net.runelite.api.TileObject;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.mahoganyhomes.contracts.ArdougneContract;
import net.runelite.client.plugins.mahoganyhomes.contracts.Contract;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.util.ImageUtil;

@PluginDescriptor(
	name = "Mahogany Homes",
	description = "Show helpful information for Mahogany Homes construction contracts",
	tags = {"construction", "minigame", "highlight", "overlay"}
)
public class MahoganyHomesPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private MahoganyHomesOverlay mahoganyHomesOverlay;

	@Inject
	private MahoganyHomesWorldOverlay mahoganyHomesWorldOverlay;

	private SkillIconManager skillIconManager;

	@Getter
	private final List<TileObject> objectsToMark = new ArrayList<>();

	@Inject
	@Getter
	private Client client;

	private Contract currentContract = null;
	private BufferedImage mapArrow;

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(mahoganyHomesOverlay);
		overlayManager.add(mahoganyHomesWorldOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(mahoganyHomesOverlay);
		overlayManager.remove(mahoganyHomesWorldOverlay);
		currentContract = null;
	}

	public BufferedImage getMapArrow()
	{
		if (mapArrow != null)
		{
			return mapArrow;
		}

		mapArrow = ImageUtil.getResourceStreamFromClass(getClass(), "/util/clue_arrow.png");

		return mapArrow;
	}

	public BufferedImage getConstructionImage()
	{
		return skillIconManager.getSkillImage(Skill.CONSTRUCTION);
	}

	public Contract getContract()
	{
		return this.currentContract;
	}
}
