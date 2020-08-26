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

public class VarrockContract extends Contract
{
	private static final ImmutableList<Integer> BOB_FURNITURE_IDS = ImmutableList.of(
		// Large Table
		NullObjectID.NULL_39981,
		// Grandfather Clock
		NullObjectID.NULL_39982,
		// Cabinet
		NullObjectID.NULL_39983,
		// Cabinet
		NullObjectID.NULL_39984,
		// Bookcase
		NullObjectID.NULL_39985,
		// Bookcase
		NullObjectID.NULL_39986,
		// Wardrobe
		NullObjectID.NULL_39987,
		// Drawers
		NullObjectID.NULL_39988
	);
	private static final ImmutableList<Integer> JEFF_FURNITURE_IDS = ImmutableList.of(
		// Jeff
		// Table
		NullObjectID.NULL_39989,
		// Bookcase
		NullObjectID.NULL_39990,
		// Shelves
		NullObjectID.NULL_39991,
		// Bed
		NullObjectID.NULL_39992,
		// Drawer
		NullObjectID.NULL_39993,
		// Dresser
		NullObjectID.NULL_39994,
		// Mirror
		NullObjectID.NULL_39995,
		// Chair
		NullObjectID.NULL_39996
	);
	private static final ImmutableList<Integer> SARAH_FURNITURE_IDS = ImmutableList.of(
		// Table
		NullObjectID.NULL_39997,
		// Bed
		NullObjectID.NULL_39998,
		// Dresser
		NullObjectID.NULL_39999,
		// Table
		NullObjectID.NULL_40000,
		// Shelf
		NullObjectID.NULL_40001,
		// Range
		NullObjectID.NULL_40286
	);

	private static final HashMap<Integer, ImmutableList<Integer>> NPC_FURNITURE_LIST = new HashMap<Integer, ImmutableList<Integer>>()
	{
		{
			put(NpcID.BOB_10414, BOB_FURNITURE_IDS);
			put(NpcID.JEFF_10415, JEFF_FURNITURE_IDS);
			put(NpcID.SARAH_10416, SARAH_FURNITURE_IDS);
		}
	};

	private static final HashMap<Integer, WorldPoint> NPC_LOCATION_LIST = new HashMap<Integer, WorldPoint>()
	{
		{
			put(NpcID.BOB_10414, new WorldPoint(0, 0, 0));
			put(NpcID.JEFF_10415, new WorldPoint(0, 0, 0));
			put(NpcID.SARAH_10416, new WorldPoint(0, 0, 0));
		}
	};

	//	private static final ImmutableList<VarrockContract> FURNITURE = ImmutableList.of(
//		// ---NPCs--- (obtained from https://oldschool.runescape.wiki/w/Mahogany_Homes)
//		// Bob
//		// Large Table
//		new VarrockContract(NullObjectID.NULL_39981, new WorldPoint(3238, 3487, 0), "Bob"),
//		// Grandfather Clock
//		new VarrockContract(NullObjectID.NULL_39982, new WorldPoint(3235, 3483, 0), "Bob"),
//		// Cabinet
//		new VarrockContract(NullObjectID.NULL_39983, new WorldPoint(3235, 3486, 0), "Bob"),
//		// Cabinet
//		new VarrockContract(NullObjectID.NULL_39984, new WorldPoint(3235, 3487, 0), "Bob"),
//		// Bookcase
//		new VarrockContract(NullObjectID.NULL_39985, new WorldPoint(3235, 3484, 0), "Bob"),
//		// Bookcase
//		new VarrockContract(NullObjectID.NULL_39986, new WorldPoint(3235, 3489, 0), "Bob"),
//		// Wardrobe
//		new VarrockContract(NullObjectID.NULL_39987, new WorldPoint(3242, 3487, 1), "Bob"),
//		// Drawers
//		new VarrockContract(NullObjectID.NULL_39988, new WorldPoint(3242, 3486, 1), "Bob"),
//
//		// Jeff
//		// Table
//		new VarrockContract(NullObjectID.NULL_39989, new WorldPoint(3238, 3452, 0), "Jeff"),
//		// Bookcase
//		new VarrockContract(NullObjectID.NULL_39990, new WorldPoint(3242, 3454, 0), "Jeff"),
//		// Shelves
//		new VarrockContract(NullObjectID.NULL_39991, new WorldPoint(3241, 3447, 0), "Jeff"),
//		// Bed
//		new VarrockContract(NullObjectID.NULL_39992, new WorldPoint(3239, 3453, 1), "Jeff"),
//		// Drawer
//		new VarrockContract(NullObjectID.NULL_39993, new WorldPoint(3242, 3454, 1), "Jeff"),
//		// Dresser
//		new VarrockContract(NullObjectID.NULL_39994, new WorldPoint(3241, 3346, 1), "Jeff"),
//		// Mirror
//		new VarrockContract(NullObjectID.NULL_39995, new WorldPoint(3238, 3454, 1), "Jeff"),
//		// Chair
//		new VarrockContract(NullObjectID.NULL_39996, new WorldPoint(3242, 3447, 1), "Jeff"),
//
//		// Sarah
//		// Table
//		new VarrockContract(NullObjectID.NULL_39997, new WorldPoint(3237, 3385, 0), "Sarah"),
//		// Bed
//		new VarrockContract(NullObjectID.NULL_39998, new WorldPoint(3234, 3384, 0), "Sarah"),
//		// Dresser
//		new VarrockContract(NullObjectID.NULL_39999, new WorldPoint(3234, 3386, 0), "Sarah"),
//		// Table
//		new VarrockContract(NullObjectID.NULL_40000, new WorldPoint(3233, 3382, 0), "Sarah"),
//		// Shelf
//		new VarrockContract(NullObjectID.NULL_40001, new WorldPoint(3234, 3382, 0), "Sarah"),
//		// Range
//		new VarrockContract(NullObjectID.NULL_40286, new WorldPoint(3237, 3382, 0), "Sarah")
//	);
//
	public VarrockContract(NpcID npc, WorldPoint location)
	{
		super(npc, Region.VARROCK, location);
	}
}
