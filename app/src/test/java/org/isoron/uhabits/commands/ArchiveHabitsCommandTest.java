/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.simpletool.goodhabit.commands;

import com.simpletool.goodhabit.*;
import com.simpletool.goodhabit.models.*;
import org.junit.*;

import java.util.*;

import static junit.framework.Assert.*;

public class ArchiveHabitsCommandTest extends BaseUnitTest
{

    private ArchiveHabitsCommand command;
    private Habit habit;

    @Override
    @Before
    public void setUp()
    {
        super.setUp();

        habit = fixtures.createShortHabit();
        command = new ArchiveHabitsCommand(habitList, Collections
            .singletonList(habit));
    }

    @Test
    public void testExecuteUndoRedo()
    {
        assertFalse(habit.isArchived());

        command.execute();
        assertTrue(habit.isArchived());

        command.undo();
        assertFalse(habit.isArchived());

        command.execute();
        assertTrue(habit.isArchived());
    }
}
