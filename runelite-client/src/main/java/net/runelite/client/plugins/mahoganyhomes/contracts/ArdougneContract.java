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

public class ArdougneContract extends Contract
{
	private static final ImmutableList<Integer> JESS_FURNITURE_IDS = ImmutableList.of(
		// Drawers to Remove: 40187, Build Space: 40082
		ObjectID.DRAWERS_40187, ObjectID.DRAWER_SPACE,
		// Cabinets to Remove: 39899, 39905, Build Space: 40073w
		ObjectID.CABINET_39899, ObjectID.CABINET_39905, ObjectID.CABINET_SPACE,
		// Bed to Remove: 40193, Build Space: 40080
		ObjectID.BED_40193, ObjectID.BED_SPACE_40080,
		// Table to Remove: 40108, Build Space: 40070
		ObjectID.TABLE_40108, ObjectID.TABLE_SPACE_40070,
		// Broken Grandfather Clock: 40141
		ObjectID.GRANDFATHER_CLOCK_40141,
		// Bath
		ObjectID.BROKEN_BATH
	);

	private static final ImmutableList<Integer> NOELLA_FURNITURE_IDS = ImmutableList.of(
		// Dresser to Remove: 33948, Build Space: 40076
		ObjectID.DRESSER_39948, ObjectID.DRESSER_SPACE_40076,
		// Cupboard to Remove: 40115, Build Space: 40078
		ObjectID.CUPBOARD_40115, ObjectID.CUPBOARD_SPACE,
		// Broken Hat stand: 40139
		ObjectID.HAT_STAND_40139,
		// Broken Mirror: 40179
		ObjectID.BROKEN_MIRROR_40179,
		// Drawers to Remove: 40181, Build Space: 40082
		ObjectID.DRAWERS_40181, ObjectID.DRAWER_SPACE,
		// Table to Remove: 40108, Build Space: 40070
		ObjectID.TABLE_40108, ObjectID.TABLE_SPACE_40070,
		// Broken Grandfather Clock: 40141
		ObjectID.GRANDFATHER_CLOCK_40141
	);

	private static final ImmutableList<Integer> ROSS_FURNITURE_IDS = ImmutableList.of(
		// Broken Range: 40148
		ObjectID.BROKEN_RANGE_40148,
		// Drawers to Remove: 40187, Build Space: 40082a
		ObjectID.DRAWERS_40187,
		// Large Bed to Remove: 40200, Build Space: 40080
		ObjectID.BED_40200, ObjectID.BED_SPACE_40080,
		// Broken Hat Stand: 40139
		ObjectID.HAT_STAND_40139,
		// Bed to Remove: 40207, Build Space: 40081
		ObjectID.BED_40207, ObjectID.BED_SPACE_40081,
		// Broken Mirror: 40179
		ObjectID.BROKEN_MIRROR_40179
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
			put(NpcID.JESS, new WorldPoint(2622, 3298, 0));
			put(NpcID.NOELLA, new WorldPoint(2659, 3328, 0));
			put(NpcID.ROSS, new WorldPoint(2614, 3322, 0));
		}
	};

	// Location mapping for Overlay
	private final HashMap<Integer, String> npcOverlayMap = new HashMap<Integer, String>()
	{
		{
			put(NpcID.JESS, "Floor above pet insurance shop");
			put(NpcID.NOELLA, "North-west of market");
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
