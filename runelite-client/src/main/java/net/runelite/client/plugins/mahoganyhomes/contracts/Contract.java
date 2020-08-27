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
package net.runelite.client.plugins.mahoganyhomes.contracts;

import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import lombok.Getter;
import net.runelite.api.NpcID;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.mahoganyhomes.MahoganyHomesPlugin;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter
public abstract class Contract
{
	public enum Region
	{
		ARDOUGNE, FALADOR, HOSIDIUS, VARROCK
	}

	public static final ImmutableList<String> NPC_NAMES = ImmutableList.of(
		// Ardougne
		"Jess", "Noella", "Ross",
		// Falador
		"Larry", "Norman", "Tau",
		// Hosidius
		"Barbara", "Leela", "Mariah",
		// Varrock
		"Bob", "Jeff", "Sarah"
	);

	public static final HashMap<String, Integer> NPC_IDS = new HashMap<String, Integer>()
	{
		{
			// Ardougne
			put("Jess", NpcID.JESS);
			put("Noella", NpcID.NOELLA);
			put("Ross", NpcID.ROSS);
			// Falador
			put("Larry", NpcID.LARRY_10418);
			put("Norman", NpcID.NORMAN);
			put("Tau", NpcID.TAU);
			// Hosidius
			put("Barbara", NpcID.BARBARA);
			put("Leela", NpcID.LEELA_10423);
			put("Mariah", NpcID.MARIAH);
			// Varrock
			put("Bob", NpcID.BOB_10414);
			put("Jeff", NpcID.JEFF_10415);
			put("Sarah", NpcID.SARAH_10416);
		}
	};

	private final String npcName;
	private final Integer npcId;
	private final Region region;
	private final WorldPoint location;

	public Contract(String npcName, Integer npcId, Region region, WorldPoint location)
	{
		this.npcName = npcName;
		this.npcId = npcId;
		this.region = region;
		this.location = location;
	}

	public void makeOverlay(PanelComponent panelComponent, MahoganyHomesPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Current Contract").build());
		panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(npcName)
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		panelComponent.getChildren().add(LineComponent.builder().left("Location:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(getHint() + ", " + getRegion())
			.leftColor(TITLED_CONTENT_COLOR)
			.build());
	}

	public abstract String getHint();

	private String getRegion()
	{
		if (region == Region.ARDOUGNE)
		{
			return "Ardougne";
		}
		if (region == Region.FALADOR)
		{
			return "Falador";
		}
		if (region == Region.HOSIDIUS)
		{
			return "Hosidius";
		}
		if (region == Region.VARROCK)
		{
			return "Varrock";
		}

		return "";
	}
}
