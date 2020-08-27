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

public class FaladorContract extends Contract
{
	private static final ImmutableList<Integer> LARRY_FURNITURE_IDS = ImmutableList.of(
		// Drawer
		NullObjectID.NULL_40095,
		// Drawer
		NullObjectID.NULL_40096,
		// Table
		NullObjectID.NULL_40097,
		// Table
		NullObjectID.NULL_40098,
		// Grandfather Clock
		NullObjectID.NULL_40099,
		// Range
		NullObjectID.NULL_40297,
		// Broken 40418
		// Fixed 40419
		// Hat Stand
		NullObjectID.NULL_40298
	);
	private static final ImmutableList<Integer> NORMAN_FURNITURE_IDS = ImmutableList.of(
		// Grandfather Clock
		NullObjectID.NULL_40089,
		// Table
		NullObjectID.NULL_40090,
		// Bed
		NullObjectID.NULL_40091,
		// Bookshelf
		NullObjectID.NULL_40092,
		// Drawers
		NullObjectID.NULL_40093,
		// Table
		NullObjectID.NULL_40094,
		// Range
		NullObjectID.NULL_40296
	);
	private static final ImmutableList<Integer> TAU_FURNITURE_IDS = ImmutableList.of(
		// Sink
		NullObjectID.NULL_40083,
		// Table
		NullObjectID.NULL_40084,
		// Table
		NullObjectID.NULL_40085,
		// Cupboard
		NullObjectID.NULL_40086,
		// Shelves
		NullObjectID.NULL_40087,
		// Shelves
		NullObjectID.NULL_40088,
		// Hat Stand
		NullObjectID.NULL_40295
	);
	// Furniture mapping for World Overlay
	private static final HashMap<Integer, ImmutableList<Integer>> npcFurnitureMap = new HashMap<Integer, ImmutableList<Integer>>()
	{
		{
			put(NpcID.LARRY_10418, LARRY_FURNITURE_IDS);
			put(NpcID.NORMAN, NORMAN_FURNITURE_IDS);
			put(NpcID.TAU, TAU_FURNITURE_IDS);
		}
	};

	// Coordinate mapping for World Map Points
	public static final HashMap<Integer, WorldPoint> npcCoordinateMap = new HashMap<Integer, WorldPoint>()
	{
		{
			put(NpcID.LARRY_10418, new WorldPoint(3040, 3367, 0));
			put(NpcID.NORMAN, new WorldPoint(3036, 3343, 0));
			put(NpcID.TAU, new WorldPoint(3044, 3345, 0));
		}
	};

	// Location map for Overlay
	public static final HashMap<Integer, String> npcOverlayMap = new HashMap<Integer, String>()
	{
		{
			put(NpcID.LARRY_10418, "North of fountain");
			put(NpcID.NORMAN, "South of fountain");
			put(NpcID.TAU, "South-east of fountain");
		}
	};

	public FaladorContract(String npc, Integer npcId)
	{
		super(npc, npcId, Region.FALADOR, npcCoordinateMap.get(npcId));
	}

	@Override
	public String getHint()
	{
		return npcOverlayMap.get(getNpcId());
	}
}
