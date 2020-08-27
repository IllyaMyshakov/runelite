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
import net.runelite.api.NpcID;
import net.runelite.api.NullObjectID;
import net.runelite.api.coords.WorldPoint;

public class HosidiusContract extends Contract
{
	private static final ImmutableList<Integer> BARBARA_FURNITURE_IDS = ImmutableList.of(
		// Grandfather Clock
		NullObjectID.NULL_40011,
		// Table
		NullObjectID.NULL_40012,
		// Bed
		NullObjectID.NULL_40013,
		// Chair
		NullObjectID.NULL_40014,
		// Chair
		NullObjectID.NULL_40015,
		// Drawers
		NullObjectID.NULL_40294
	);
	private static final ImmutableList<Integer> LEELA_FURNITURE_IDS = ImmutableList.of(
		// Table
		NullObjectID.NULL_40007,
		// Table
		NullObjectID.NULL_40008,
		// Table
		NullObjectID.NULL_40009,
		// Mirror
		NullObjectID.NULL_40010,
		// Sink
		NullObjectID.NULL_40290,
		// Bed
		NullObjectID.NULL_40291,
		// Cupboard
		NullObjectID.NULL_40292
	);
	private static final ImmutableList<Integer> MARIAH_FURNITURE_IDS = ImmutableList.of(
		// Mariah
		// Table
		NullObjectID.NULL_40002,
		// Shelves
		NullObjectID.NULL_40003,
		// Bed
		NullObjectID.NULL_40004,
		// Table
		NullObjectID.NULL_40005,
		// Sink
		NullObjectID.NULL_40287,
		// Cupboard
		NullObjectID.NULL_40288,
		// Hat Stand
		NullObjectID.NULL_40289
	);
	// Furniture mapping for World Overlay
	private static final HashMap<Integer, ImmutableList<Integer>> npcFurnitureMap = new HashMap<Integer, ImmutableList<Integer>>()
	{
		{
			put(NpcID.BARBARA, BARBARA_FURNITURE_IDS);
			put(NpcID.LEELA_10423, LEELA_FURNITURE_IDS);
			put(NpcID.MARIAH, MARIAH_FURNITURE_IDS);
		}
	};

	// Coordinate mapping for World Map Points
	public static final HashMap<Integer, WorldPoint> npcCoordinateMap = new HashMap<Integer, WorldPoint>()
	{
		{
			put(NpcID.BARBARA, new WorldPoint(1750, 3532, 0));
			put(NpcID.LEELA_10423, new WorldPoint(1787, 3594, 0));
			put(NpcID.MARIAH, new WorldPoint(1766, 3619, 0));
		}
	};

	// Location map for Overlay
	public static final HashMap<Integer, String> npcOverlayMap = new HashMap<Integer, String>()
	{
		{
			put(NpcID.BARBARA, "South-east of wind mill");
			put(NpcID.LEELA_10423, "North-east of Cooking Hall");
			put(NpcID.MARIAH, "South-west of estate agent");
		}
	};

	public HosidiusContract(String npc, Integer npcId)
	{
		super(npc, npcId, Region.HOSIDIUS, npcCoordinateMap.get(npcId));
	}

	@Override
	public String getHint()
	{
		return npcOverlayMap.get(getNpcId());
	}
}
