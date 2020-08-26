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

	private static final HashMap<Integer, ImmutableList<Integer>> NPC_FURNITURE_LIST = new HashMap<Integer, ImmutableList<Integer>>()
	{
		{
			put(NpcID.BARBARA, BARBARA_FURNITURE_IDS);
			put(NpcID.LEELA_10423, LEELA_FURNITURE_IDS);
			put(NpcID.MARIAH, MARIAH_FURNITURE_IDS);
		}
	};

	private static final HashMap<Integer, WorldPoint> NPC_LOCATION_LIST = new HashMap<Integer, WorldPoint>()
	{
		{
			put(NpcID.BARBARA, new WorldPoint(0,0,0));
			put(NpcID.LEELA_10423, new WorldPoint(0,0,0));
			put(NpcID.MARIAH, new WorldPoint(0,0,0));
		}
	};

//	private static final ImmutableList<HosidiusContract> FURNITURE = ImmutableList.of(
//		// ---NPCs--- (obtained from https://oldschool.runescape.wiki/w/Mahogany_Homes)
//		// Barbara
//		// Grandfather Clock
//		new HosidiusContract(NullObjectID.NULL_40011, new WorldPoint(1749, 3536, 0), "Barbara"),
//		// Table
//		new HosidiusContract(NullObjectID.NULL_40012, new WorldPoint(1752, 3535, 0), "Barbara"),
//		// Bed
//		new HosidiusContract(NullObjectID.NULL_40013, new WorldPoint(1749, 3539, 0), "Barbara"),
//		// Chair
//		new HosidiusContract(NullObjectID.NULL_40014, new WorldPoint(1751, 3534, 0), "Barbara"),
//		// Chair
//		new HosidiusContract(NullObjectID.NULL_40015, new WorldPoint(1750, 3532, 0), "Barbara"),
//		// Drawers
//		new HosidiusContract(NullObjectID.NULL_40294, new WorldPoint(1754, 3535, 0), "Barbara"),
//
//		// Leela
//		// Table
//		new HosidiusContract(NullObjectID.NULL_40007, new WorldPoint(1784, 3594, 0), "Leela"),
//		// Table
//		new HosidiusContract(NullObjectID.NULL_40008, new WorldPoint(1782, 3592, 0), "Leela"),
//		// Table
//		new HosidiusContract(NullObjectID.NULL_40009, new WorldPoint(1782, 3592, 1), "Leela"),
//		// Mirror
//		new HosidiusContract(NullObjectID.NULL_40010, new WorldPoint(1786, 3590, 1), "Leela"),
//		// Sink
//		new HosidiusContract(NullObjectID.NULL_40290, new WorldPoint(1787, 3594, 0), "Leela"),
//		// Bed
//		new HosidiusContract(NullObjectID.NULL_40291, new WorldPoint(1783, 3591, 0), "Leela"),
//		// Cupboard
//		new HosidiusContract(NullObjectID.NULL_40292, new WorldPoint(1788, 3590, 1), "Leela"),
//
//		// Mariah
//		// Table
//		new HosidiusContract(NullObjectID.NULL_40002, new WorldPoint(1770, 3622, 0), "Mariah"),
//		// Shelves
//		new HosidiusContract(NullObjectID.NULL_40003, new WorldPoint(1766, 3619, 0), "Mariah"),
//		// Bed
//		new HosidiusContract(NullObjectID.NULL_40004, new WorldPoint(1765, 3622, 1), "Mariah"),
//		// Table
//		new HosidiusContract(NullObjectID.NULL_40005, new WorldPoint(1764, 3620, 1), "Mariah"),
//		// Sink
//		new HosidiusContract(NullObjectID.NULL_40287, new WorldPoint(1763, 3622, 0), "Mariah"),
//		// Cupboard
//		new HosidiusContract(NullObjectID.NULL_40288, new WorldPoint(1763, 3620, 0), "Mariah"),
//		// Hat Stand
//		new HosidiusContract(NullObjectID.NULL_40289, new WorldPoint(1764, 3623, 0), "Mariah")
//	);

	public HosidiusContract(NpcID npc, WorldPoint location)
	{
		super(npc, Region.HOSIDIUS, location);
	}
}
