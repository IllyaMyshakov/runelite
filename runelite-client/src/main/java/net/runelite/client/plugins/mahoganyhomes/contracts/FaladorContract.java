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

public class FaladorContract extends Contract
{
	private static final ImmutableList<Integer> LARRY_FURNITURE_IDS = ImmutableList.of(
		// Drawer to Remove: 40151, Build Space: 40082
		ObjectID.DRAWERS_40151, ObjectID.DRAWER_SPACE,
		// Table to Remove: 40102, Build Space: 40070
		ObjectID.TABLE_40102, ObjectID.TABLE_SPACE_40070,
		// Broken Grandfather Clock: 40141
		ObjectID.GRANDFATHER_CLOCK_40141,
		// Broken Range: 40418
		ObjectID.BROKEN_RANGE_40148,
		// Broken Hat Stand: 40139
		ObjectID.HAT_STAND_40139
	);
	private static final ImmutableList<Integer> NORMAN_FURNITURE_IDS = ImmutableList.of(
		// Broken Grandfather Clock: 40141
		ObjectID.GRANDFATHER_CLOCK_40141,
		// Table to Remove: 40102, Build Space: 40070
		ObjectID.TABLE_40102, ObjectID.TABLE_SPACE_40070,
		// Bed to Remove: 40128, Build Space: 40080
		ObjectID.BED_40128, ObjectID.BED_SPACE_40080,
		// Bookshelf to Remove: 40134, Build Space: 40074
		ObjectID.OLD_BOOKSHELF_40134, ObjectID.BOOKCASE_SPACE_40074,
		// Drawers to Remove: 40143, Build Space: 40082
		ObjectID.DRAWERS_40143, ObjectID.DRAWER_SPACE,
		// Table to Remove: 39967, Build Space: 40069
		ObjectID.TABLE_39967, ObjectID.TABLE_SPACE_40069,
		// Broken Range: 40148
		ObjectID.BROKEN_RANGE_40148
	);
	private static final ImmutableList<Integer> TAU_FURNITURE_IDS = ImmutableList.of(
		// Sink to Remove: ,_________
		ObjectID.BROKEN_SINK,
		// Tables to Remove: 40102, 40108, Build Space: 40070
		ObjectID.TABLE_40102, ObjectID.TABLE_40108, ObjectID.TABLE_SPACE_40070,
		// Cupboard to Remove: 40115, Build Space: 40078
		ObjectID.CUPBOARD_40115, ObjectID.CUPBOARD_SPACE,
		// Shelves to Remove: 40121, Build Space: 40077
		ObjectID.SHELVES_40121, ObjectID.SHELVES_SPACE,
		// Broken Hat Stand: 40139
		ObjectID.HAT_STAND_40139
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
			put(NpcID.LARRY_10418, new WorldPoint(3038, 3370, 0));
			put(NpcID.NORMAN, new WorldPoint(3038, 3350, 0));
			put(NpcID.TAU, new WorldPoint(3048, 3352, 0));
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
