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

	private static final HashMap<Integer, ImmutableList<Integer>> NPC_FURNITURE_LIST = new HashMap<Integer, ImmutableList<Integer>>()
	{
		{
			put(NpcID.JESS, JESS_FURNITURE_IDS);
			put(NpcID.NOELLA, NOELLA_FURNITURE_IDS);
			put(NpcID.ROSS, ROSS_FURNITURE_IDS);
		}
	};

	private static final HashMap<Integer, WorldPoint> NPC_LOCATION_LIST = new HashMap<Integer, WorldPoint>()
	{
		{
			put(NpcID.JESS, new WorldPoint(0, 0, 0));
			put(NpcID.NOELLA, new WorldPoint(0, 0, 0));
			put(NpcID.ROSS, new WorldPoint(0, 0, 0));
		}
	};
//		);
//	private static final ImmutableList<ArdougneContract> FURNITURE = ImmutableList.of(
//		// ---NPCs--- (obtained from https://oldschool.runescape.wiki/w/Mahogany_Homes)
//		// Jess
//		// Drawers
//		new ArdougneContract(NullObjectID.NULL_40171, new WorldPoint(2612, 3296, 1), "Jess"),
//		// Drawers
//		new ArdougneContract(NullObjectID.NULL_40172, new WorldPoint(2620, 3291, 1), "Jess"),
//		// Cabinet
//		new ArdougneContract(NullObjectID.NULL_40173, new WorldPoint(2621, 3295, 1), "Jess"),
//		// Cabinet
//		new ArdougneContract(NullObjectID.NULL_40174, new WorldPoint(2622, 3295, 1), "Jess"),
//		// Bed
//		new ArdougneContract(NullObjectID.NULL_40175, new WorldPoint(2615, 3296, 1), "Jess"),
//		// Table
//		new ArdougneContract(NullObjectID.NULL_40176, new WorldPoint(2612, 3294, 1), "Jess"),
//		// Bath
//		new ArdougneContract(NullObjectID.NULL_40299, new WorldPoint(2616, 3291, 1), "Jess"),
//
//		// Noella
//		// Dresser
//		new ArdougneContract(NullObjectID.NULL_40156, new WorldPoint(2662, 3323, 1), "Noella"),
//		// Cupboard
//		new ArdougneContract(NullObjectID.NULL_40157, new WorldPoint(2661, 3321, 1), "Noella"),
//		// Hat stand
//		new ArdougneContract(NullObjectID.NULL_40158, new WorldPoint(2665, 3318, 1), "Noella"),
//		// Mirror
//		new ArdougneContract(NullObjectID.NULL_40159, new WorldPoint(2661, 3318, 1), "Noella"),
//		// Drawers
//		new ArdougneContract(NullObjectID.NULL_40160, new WorldPoint(2657, 3322, 1), "Noella"),
//		// Table
//		new ArdougneContract(NullObjectID.NULL_40161, new WorldPoint(2654, 3320, 1), "Noella"),
//		// Table
//		new ArdougneContract(NullObjectID.NULL_40162, new WorldPoint(2657, 3318, 1), "Noella"),
//		// Grandfather Clock
//		new ArdougneContract(NullObjectID.NULL_40163, new WorldPoint(2653, 3322, 1), "Noella"),
//
//		// Ross
//		// Range
//		new ArdougneContract(NullObjectID.NULL_40164, new WorldPoint(2617, 3318, 0), "Ross"),
//		// Drawers
//		new ArdougneContract(NullObjectID.NULL_40165, new WorldPoint(2611, 3318, 0), "Ross"),
//		// Drawers
//		new ArdougneContract(NullObjectID.NULL_40166, new WorldPoint(2611, 3315, 0), "Ross"),
//		// Large Bed
//		new ArdougneContract(NullObjectID.NULL_40167, new WorldPoint(2614, 3318, 1), "Ross"),
//		// Hat Stand
//		new ArdougneContract(NullObjectID.NULL_40168, new WorldPoint(2615, 3316, 1), "Ross"),
//		// Bed
//		new ArdougneContract(NullObjectID.NULL_40169, new WorldPoint(2618, 3319, 1), "Ross"),
//		// Mirror
//		new ArdougneContract(NullObjectID.NULL_40170, new WorldPoint(2618, 3317, 1), "Ross")
//
//	);

	public ArdougneContract(NpcID npc, WorldPoint location)
	{
		super(npc, Region.ARDOUGNE, location);
	}
}
