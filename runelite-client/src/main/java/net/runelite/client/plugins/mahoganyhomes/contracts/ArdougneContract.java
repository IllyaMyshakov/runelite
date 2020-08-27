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

public class ArdougneContract extends Contract
{
	private static final ImmutableList<Integer> JESS_FURNITURE_IDS = ImmutableList.of(
		// Drawers
		NullObjectID.NULL_40171,
		// Drawers
		NullObjectID.NULL_40172,
		// Cabinet
		NullObjectID.NULL_40173,
		// Cabinet
		NullObjectID.NULL_40174,
		// Bed
		NullObjectID.NULL_40175,
		// Table
		NullObjectID.NULL_40176,
		// Bath
		NullObjectID.NULL_40299
	);

	private static final ImmutableList<Integer> NOELLA_FURNITURE_IDS = ImmutableList.of(
		// Dresser
		NullObjectID.NULL_40156,
		// Cupboard
		NullObjectID.NULL_40157,
		// Hat stand
		NullObjectID.NULL_40158,
		// Mirror
		NullObjectID.NULL_40159,
		// Drawers
		NullObjectID.NULL_40160,
		// Table
		NullObjectID.NULL_40161,
		// Table
		NullObjectID.NULL_40162,
		// Grandfather Clock
		NullObjectID.NULL_40163
	);

	private static final ImmutableList<Integer> ROSS_FURNITURE_IDS = ImmutableList.of(
		// Range
		NullObjectID.NULL_40164,
		// Drawers
		NullObjectID.NULL_40165,
		// Drawers
		NullObjectID.NULL_40166,
		// Large Bed
		NullObjectID.NULL_40167,
		// Hat Stand
		NullObjectID.NULL_40168,
		// Bed
		NullObjectID.NULL_40169,
		// Mirror
		NullObjectID.NULL_40170
	);

	// Furniture mapping for World Overlay
	private static final HashMap<Integer, ImmutableList<Integer>> npcFurnitureMap = new HashMap<Integer, ImmutableList<Integer>>()
	{
		{
			put(NpcID.JESS, JESS_FURNITURE_IDS);
			put(NpcID.NOELLA, NOELLA_FURNITURE_IDS);
			put(NpcID.ROSS, ROSS_FURNITURE_IDS);
		}
	};

	// Coordinate mapping for World Map Points
	public static final HashMap<Integer, WorldPoint> npcCoordinateMap = new HashMap<Integer, WorldPoint>()
	{
		{
			put(NpcID.JESS, new WorldPoint(2621, 3295, 0));
			put(NpcID.NOELLA, new WorldPoint(2654, 3320, 0));
			put(NpcID.ROSS, new WorldPoint(2614, 3318, 0));
		}
	};

	// Location mapping for Overlay
	private final HashMap<Integer, String> npcOverlayMap = new HashMap<Integer, String>()
	{
		{
			put(NpcID.JESS, "Floor above pet insurance shop, south of church");
			put(NpcID.NOELLA, "Floor above gem store north-west of market");
			put(NpcID.ROSS, "North of church");
		}
	};

	public ArdougneContract(String npc, Integer npcId)
	{
		super(npc, npcId, Region.ARDOUGNE, npcCoordinateMap.get(npcId));
	}
	@Override
	public String getHint()
	{
		return npcOverlayMap.get(getNpcId());
	}
}
