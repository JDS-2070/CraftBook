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
package org.enginehub.craftbook.sponge.util.data.builder;

import org.enginehub.craftbook.sponge.util.data.CraftBookKeys;
import org.enginehub.craftbook.sponge.util.data.immutable.ImmutableBlockBagData;
import org.enginehub.craftbook.sponge.util.data.mutable.BlockBagData;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.util.annotation.NonnullByDefault;

import java.util.Optional;

@NonnullByDefault
public class BlockBagDataManipulatorBuilder extends AbstractDataBuilder<BlockBagData>  implements DataManipulatorBuilder<BlockBagData, ImmutableBlockBagData> {

    public BlockBagDataManipulatorBuilder() {
        super(BlockBagData.class, 1);
    }

    @Override
    public BlockBagData create() {
        return new BlockBagData();
    }

    @Override
    public Optional<BlockBagData> createFrom(DataHolder dataHolder) {
        return create().fill(dataHolder);
    }

    @Override
    protected Optional<BlockBagData> buildContent(DataView container) throws InvalidDataException {
        if (container.contains(CraftBookKeys.BLOCK_BAG.getQuery())) {
            return Optional.of(new BlockBagData(container.getLong(CraftBookKeys.BLOCK_BAG.getQuery()).get()));
        }

        return Optional.empty();
    }
}