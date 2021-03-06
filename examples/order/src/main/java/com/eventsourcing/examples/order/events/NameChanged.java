/**
 * Copyright (c) 2016, All Contributors (see CONTRIBUTORS file)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.eventsourcing.examples.order.events;

import com.eventsourcing.StandardEvent;
import com.eventsourcing.annotations.Index;
import com.eventsourcing.hlc.HybridTimestamp;
import com.eventsourcing.index.SimpleAttribute;
import com.googlecode.cqengine.query.option.QueryOptions;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.UUID;

import static com.eventsourcing.index.IndexEngine.IndexFeature.*;

@Accessors(fluent = true)
public class NameChanged extends StandardEvent {
    @Getter
    private final UUID id;
    @Getter
    private final String name;

    @Index({EQ})
    public static final SimpleAttribute<NameChanged, UUID> REFERENCE_ID = new SimpleAttribute<NameChanged, UUID>(
            "referenceId") {
        public UUID getValue(NameChanged nameChanged, QueryOptions queryOptions) {
            return nameChanged.id();
        }
    };

    @Index({EQ, LT, GT})
    public static final SimpleAttribute<NameChanged, HybridTimestamp> TIMESTAMP = new SimpleAttribute<NameChanged, HybridTimestamp>(
            "timestamp") {
        public HybridTimestamp getValue(NameChanged nameChanged, QueryOptions queryOptions) {
            return nameChanged.timestamp();
        }
    };

    @Builder
    public NameChanged(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
