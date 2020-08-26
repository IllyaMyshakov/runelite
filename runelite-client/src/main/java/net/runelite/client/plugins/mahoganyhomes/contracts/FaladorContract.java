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

	private static final HashMap<Integer, ImmutableList<Integer>> NPC_FURNITURE_LIST = new HashMap<Integer, ImmutableList<Integer>>()
	{
		{
			put(NpcID.LARRY_10418, LARRY_FURNITURE_IDS);
			put(NpcID.NORMAN, NORMAN_FURNITURE_IDS);
			put(NpcID.TAU, TAU_FURNITURE_IDS);
		}
	};

	private static final HashMap<Integer, WorldPoint> NPC_LOCATION_LIST = new HashMap<Integer, WorldPoint>()
	{
		{
			put(NpcID.LARRY_10418, new WorldPoint(0, 0, 0));
			put(NpcID.NORMAN, new WorldPoint(0, 0, 0));
			put(NpcID.TAU, new WorldPoint(0, 0, 0));
		}
	};

//	private static final ImmutableList<FaladorContract> FURNITURE = ImmutableList.of(
//		// ---NPCs--- (obtained from https://oldschool.runescape.wiki/w/Mahogany_Homes)
//		// Larry
//		// Drawer
//		new FaladorContract(NullObjectID.NULL_40095, new WorldPoint(3041, 3365, 0), "Larry"),
//		// Drawer
//		new FaladorContract(NullObjectID.NULL_40096, new WorldPoint(3041, 3364, 0), "Larry"),
//		// Table
//		new FaladorContract(NullObjectID.NULL_40097, new WorldPoint(3038, 3365, 0), "Larry"),
//		// Table
//		new FaladorContract(NullObjectID.NULL_40098, new WorldPoint(3039, 3363, 1), "Larry"),
//		// Grandfather Clock
//		new FaladorContract(NullObjectID.NULL_40099, new WorldPoint(3034, 3364, 1), "Larry"),
//		// Range
//		new FaladorContract(NullObjectID.NULL_40297, new WorldPoint(3040, 3367, 0), "Larry"),
//		// Hat Stand
//		new FaladorContract(NullObjectID.NULL_40298, new WorldPoint(3041, 3362, 0), "Larry"),
//
//		// Norman
//		// Grandfather Clock
//		new FaladorContract(NullObjectID.NULL_40089, new WorldPoint(3035, 3346, 0), "Norman"),
//		// Table
//		new FaladorContract(NullObjectID.NULL_40090, new WorldPoint(3036, 3343, 0), "Norman"),
//		// Bed
//		new FaladorContract(NullObjectID.NULL_40091, new WorldPoint(3040, 3347, 1), "Norman"),
//		// Bookshelf
//		new FaladorContract(NullObjectID.NULL_40092, new WorldPoint(3035, 3346, 1), "Norman"),
//		// Drawers
//		new FaladorContract(NullObjectID.NULL_40093, new WorldPoint(3035, 3347, 1), "Norman"),
//		// Table
//		new FaladorContract(NullObjectID.NULL_40094, new WorldPoint(3040, 3345, 1), "Norman"),
//		// Range
//		new FaladorContract(NullObjectID.NULL_40296, new WorldPoint(3040, 3346, 0), "Norman"),
//
//		// Tau
//		// Sink
//		new FaladorContract(NullObjectID.NULL_40083, new WorldPoint(3051, 3348, 0), "Tau"),
//		// Table
//		new FaladorContract(NullObjectID.NULL_40084, new WorldPoint(3048, 3345, 0), "Tau"),
//		// Table
//		new FaladorContract(NullObjectID.NULL_40085, new WorldPoint(3049, 3349, 0), "Tau"),
//		// Cupboard
//		new FaladorContract(NullObjectID.NULL_40086, new WorldPoint(3044, 3345, 0), "Tau"),
//		// Shelves
//		new FaladorContract(NullObjectID.NULL_40087, new WorldPoint(3047, 3341, 0), "Tau"),
//		// Shelves
//		new FaladorContract(NullObjectID.NULL_40088, new WorldPoint(3048, 3341, 0), "Tau"),
//		// Hat Stand
//		new FaladorContract(NullObjectID.NULL_40295, new WorldPoint(3046, 3341, 0), "Tau")
//
//	);

	public FaladorContract(NpcID npc, WorldPoint location)
	{
		super(npc, Region.FALADOR, location);
	}
}
