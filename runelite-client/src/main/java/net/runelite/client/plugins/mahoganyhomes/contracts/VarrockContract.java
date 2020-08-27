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
import net.runelite.api.ObjectID;
import net.runelite.api.coords.WorldPoint;

public class VarrockContract extends Contract
{
	private static final ImmutableList<Integer> BOB_FURNITURE_IDS = ImmutableList.of(
		// Large Table to Remove: 39892, Build Space: 40071
		ObjectID.TEAK_TABLE_39892, ObjectID.TABLE_SPACE_40071,
		// Broken Grandfather Clock: 39897
		ObjectID.BROKEN_GRANDFATHER_CLOCK,
		// Cabinets to Remove: 39899, 39905, Build Space: 40073
		ObjectID.CABINET_39899, ObjectID.CABINET_39905, ObjectID.CABINET_SPACE,
		// Bookcase to Remove: 39911, Build Space: 40074
		ObjectID.BOOKCASE_39911, ObjectID.BOOKCASE_SPACE_40074,
		// Wardrobe to Remove: 39917, Build Space: 40075
		ObjectID.WARDROBE_39917, ObjectID.WARDROBE_SPACE_40075,
		// Drawers to Remove: 39923, Build Space: 40082
		ObjectID.DRAWERS_39923, ObjectID.DRAWER_SPACE
	);
	private static final ImmutableList<Integer> JEFF_FURNITURE_IDS = ImmutableList.of(
		// Table to Remove: , Build Space: 40070
		NullObjectID.NULL_39989, ObjectID.TABLE_SPACE_40070,
		// Bookcase to Remove: 39911, Build Space: 40074
		ObjectID.BOOKCASE_39911, ObjectID.BOOKCASE_SPACE_40074,
		// Shelves to Remove: 39935, Build Space: 40077
		ObjectID.SHELVES_39935, ObjectID.SHELVES_SPACE,
		// Bed to Remove: 39942, Build Space: 40080
		ObjectID.BED_39942, ObjectID.BED_SPACE_40080,
		// Drawer to Remove: 39923, Build Space: 40082
		ObjectID.DRAWERS_39923, ObjectID.DRAWER_SPACE,
		// Dresser to Remove: 39948, Build Space: 40076
		ObjectID.DRESSER_39948, ObjectID.DRESSER_SPACE_40076,
		// Broken Mirror: 39953
		ObjectID.BROKEN_MIRROR,
		// Chair to Remove: 39955, Build Space: 40079
		ObjectID.CHAIR_39955, ObjectID.CHAIR_SPACE_40079
	);
	// Furniture mapping for World Overlay
	private static final ImmutableList<Integer> SARAH_FURNITURE_IDS = ImmutableList.of(
		// Tables to Remove: 39961, 39967, Build Space: 40069, 40070
		ObjectID.TABLE_39961, ObjectID.TABLE_39967, ObjectID.TABLE_SPACE_40069, ObjectID.TABLE_SPACE_40070,
		// Bed to Remove: 39974, Build Space: 40081
		ObjectID.BED_39974, ObjectID.BED_SPACE_40081,
		// Dresser to Remove: 39948, Build Space: 40076
		ObjectID.DRESSER_39948, ObjectID.DRESSER_SPACE_40076,
		// Shelves to Remove: 39935, Build Space: 40077
		ObjectID.SHELVES_39935, ObjectID.SHELVES_SPACE,
		// Broken Range: 40148
		ObjectID.BROKEN_RANGE_40148
	);
	// Furniture mapping for World Overlay
	private static final HashMap<Integer, ImmutableList<Integer>> npcFurnitureMap = new HashMap<Integer, ImmutableList<Integer>>()
	{
		{
			put(NpcID.BOB_10414, BOB_FURNITURE_IDS);
			put(NpcID.JEFF_10415, JEFF_FURNITURE_IDS);
			put(NpcID.SARAH_10416, SARAH_FURNITURE_IDS);
		}
	};

	// Coordinate mapping for World Map Points
	public static final HashMap<Integer, WorldPoint> npcCoordinateMap = new HashMap<Integer, WorldPoint>()
	{
		{
			put(NpcID.BOB_10414, new WorldPoint(3238, 3493, 0));
			put(NpcID.JEFF_10415, new WorldPoint(3240, 3456, 0));
			put(NpcID.SARAH_10416, new WorldPoint(3235, 3390, 0));
		}
	};

	// Location map for Overlay
	public static final HashMap<Integer, String> npcOverlayMap = new HashMap<Integer, String>()
	{
		{
			put(NpcID.BOB_10414, "North of estate agent");
			put(NpcID.JEFF_10415, "South of estate agent");
			put(NpcID.SARAH_10416, "Along South wall");
		}
	};

	public VarrockContract(String npc, Integer npcId)
	{
		super(npc, npcId, Region.VARROCK, npcCoordinateMap.get(npcId));
	}

	@Override
	public String getHint()
	{
		return npcOverlayMap.get(getNpcId());
	}
}
