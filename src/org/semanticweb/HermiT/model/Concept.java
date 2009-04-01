// Copyright 2008 by Oxford University; see license.txt for details
package org.semanticweb.HermiT.model;

import java.io.Serializable;

import org.semanticweb.HermiT.*;

/**
 * Represents a (complex) concept.
 */
public abstract class Concept implements Serializable {
    private static final long serialVersionUID=-8685976675539160944L;

    public abstract boolean isAlwaysTrue();
    public abstract boolean isAlwaysFalse();
    public abstract String toString(Prefixes prefixes);
    public String toString() {
        return toString(Prefixes.EMPTY);
    }
}
