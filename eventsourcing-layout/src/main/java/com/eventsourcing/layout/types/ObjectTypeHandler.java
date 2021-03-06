/**
 * Copyright (c) 2016, All Contributors (see CONTRIBUTORS file)
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.eventsourcing.layout.types;

import com.eventsourcing.layout.Layout;
import com.eventsourcing.layout.TypeHandler;
import lombok.Getter;
import lombok.SneakyThrows;

public class ObjectTypeHandler<T> implements TypeHandler {

    @Getter
    private final Class wrappedClass;
    @Getter
    private final Layout<T> layout;

    public ObjectTypeHandler() {
        wrappedClass = Object.class;
        layout = null;
    }

    @SneakyThrows
    public ObjectTypeHandler(Class<T> wrappedClass) {
        this.wrappedClass = wrappedClass;
        layout = Layout.forClass(wrappedClass);
    }

    @Override
    public byte[] getFingerprint() {
        return layout.getHash();
    }


    @Override public int hashCode() {
        return "Object".hashCode();
    }

    @Override public boolean equals(Object obj) {
        return obj instanceof ObjectTypeHandler && obj.hashCode() == hashCode();
    }
}
