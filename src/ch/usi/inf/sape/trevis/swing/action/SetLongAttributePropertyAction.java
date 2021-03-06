/*
 * This file is licensed to You under the "Simplified BSD License".
 * You may not use this software except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/bsd-license.php
 *
 * See the COPYRIGHT file distributed with this work for information
 * regarding copyright ownership.
 */
package ch.usi.inf.sape.trevis.swing.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ch.usi.inf.sape.trevis.model.attribute.LongAttribute;
import ch.usi.inf.sape.trevis.swing.Property;
import ch.usi.inf.sape.trevis.swing.PropertyListener;


/**
 * Set the given Property to the given LongAttribute.
 * 
 * @author Matthias.Hauswirth@usi.ch
 */
public final class SetLongAttributePropertyAction extends AbstractAction {

	private final Property property;
	private final LongAttribute attribute;
	
	
	public SetLongAttributePropertyAction(final Property property, final LongAttribute attribute) {
		this.property = property;
		this.attribute = attribute;
		setEnabled(property.getLongAttribute()!=attribute);
		putValue(NAME, attribute.getName());
		putValue(SHORT_DESCRIPTION, "Set "+property.getName()+" to "+attribute.getDescription());
		
		// register listeners
		property.addPropertyListener(new PropertyListener() {
			public void propertyChanged(final Property property) {
				setEnabled(property.getLongAttribute()!=attribute);
			}
		});
	}
		
	public void actionPerformed(final ActionEvent ev) {
		property.setLongAttribute(attribute);
	}

}
