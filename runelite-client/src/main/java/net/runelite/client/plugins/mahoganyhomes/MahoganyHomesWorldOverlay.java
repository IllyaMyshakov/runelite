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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Shape;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.Player;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.plugins.mahoganyhomes.contracts.Contract;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class MahoganyHomesWorldOverlay extends Overlay
{
	public static final int IMAGE_Z_OFFSET = 30;
	private static final int MAX_DISTANCE = 2350;
	private static final Color GREEN = new Color(0, 200, 83);
	public static final Color CLICKBOX_BORDER_COLOR = Color.RED;
	public static final Color CLICKBOX_HOVER_BORDER_COLOR = CLICKBOX_BORDER_COLOR.darker();
	public static final Color CLICKBOX_FILL_COLOR = new Color(255, 0, 0, 20);

	private final MahoganyHomesPlugin plugin;
	private final Client client;

	@Inject
	private MahoganyHomesWorldOverlay(MahoganyHomesPlugin plugin, Client client)
	{
		setPosition(OverlayPosition.DYNAMIC);
		setLayer(OverlayLayer.ABOVE_SCENE);
		this.plugin = plugin;
		this.client = client;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Contract contract = plugin.getContract();

		if (contract != null)
		{
			Player local = client.getLocalPlayer();
			renderTiles(graphics, local);
		}

		return null;
	}

	private void renderTiles(Graphics2D graphics, Player local)
	{
		LocalPoint localLocation = local.getLocalLocation();


	}

	private void renderFurniture(Graphics2D graphics, Tile tile, Player player)
	{
		GameObject[] gameObjects = tile.getGameObjects();
		if (gameObjects != null)
		{
			for (GameObject gameObject : gameObjects)
			{
				if (gameObject != null)
				{
					if (player.getLocalLocation().distanceTo(gameObject.getLocalLocation()) <= MAX_DISTANCE)
					{
						OverlayUtil.renderTileOverlay(graphics, gameObject, "ID: " + gameObject.getId(), GREEN);
					}

					// Draw a polygon around the convex hull
					// of the model vertices
					Shape p = gameObject.getConvexHull();
					if (p != null)
					{
						graphics.draw(p);
					}
				}
			}
		}
	}
}
