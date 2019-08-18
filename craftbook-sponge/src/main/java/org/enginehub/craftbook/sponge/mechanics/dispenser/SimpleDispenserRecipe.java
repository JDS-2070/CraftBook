/*
 * CraftBook Copyright (C) me4502 <https://matthewmiller.dev/>
 * CraftBook Copyright (C) EngineHub and Contributors <https://enginehub.org/>
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package org.enginehub.craftbook.sponge.mechanics.dispenser;

import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackComparators;

public abstract class SimpleDispenserRecipe implements DispenserRecipe {

    private ItemStack[] recipe;

    public SimpleDispenserRecipe(ItemStack[] recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean doesPass(ItemStack[] checkRecipe) {
        for (int i = 0; i < checkRecipe.length; i++) {
            if (ItemStackComparators.TYPE.compare(recipe[i], checkRecipe[i]) != 0
                    && !(checkRecipe[i].isEmpty() && recipe[i].getType() == ItemTypes.AIR)) {
                return false;
            }
        }

        return true;
    }
}