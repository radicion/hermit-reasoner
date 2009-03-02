// Copyright 2008 by Oxford University; see license.txt for details
package org.semanticweb.HermiT.model;

import org.semanticweb.HermiT.Namespaces;
import org.semanticweb.HermiT.model.dataranges.AbstractDataRange;
import org.semanticweb.HermiT.model.dataranges.DataRange;

/**
 * Represents an at-least data property concept.
 */
public class AtLeastConcreteRoleConcept extends ExistentialConcept implements DLPredicate {

    private static final long serialVersionUID=-9188905009088347624L;

    protected final int m_number;
    protected final AtomicRole m_onAtomicConcreteRole;
    protected final AbstractDataRange m_toDataRange;

    protected AtLeastConcreteRoleConcept(int number,AtomicRole onAtomicConcreteRole,AbstractDataRange toDataRange) {
        m_number=number;
        m_onAtomicConcreteRole=onAtomicConcreteRole;
        m_toDataRange=toDataRange;
    }
    public int getNumber() {
        return m_number;
    }
    public AtomicRole getOnAtomicConcreteRole() {
        return m_onAtomicConcreteRole;
    }
    public AbstractDataRange getToDataRange() {
        return m_toDataRange;
    }
    public int getArity() {
        return 1;
    }
    public String toString(Namespaces namespaces) {
        return "atLeast("+m_number+' '+m_onAtomicConcreteRole.toString(namespaces)+' '+m_toDataRange.toString(namespaces)+')';
    }
    protected Object readResolve() {
        return s_interningManager.intern(this);
    }

    protected static InterningManager<AtLeastConcreteRoleConcept> s_interningManager=new InterningManager<AtLeastConcreteRoleConcept>() {
        protected boolean equal(AtLeastConcreteRoleConcept object1,AtLeastConcreteRoleConcept object2) {
            return object1.getNumber()==object2.getNumber()&&object1.getOnAtomicConcreteRole()==object2.getOnAtomicConcreteRole()&&object1.getToDataRange()==object2.getToDataRange();
        }
        protected int getHashCode(AtLeastConcreteRoleConcept object) {
            return (object.getNumber()*7+object.getOnAtomicConcreteRole().hashCode())*7+object.getToDataRange().hashCode();
        }
    };
    
    public static AtLeastConcreteRoleConcept create(int number,AtomicRole onAbstractDataProperty,DataRange toDataRange) {
        return s_interningManager.intern(new AtLeastConcreteRoleConcept(number,onAbstractDataProperty,toDataRange));
    }
}
