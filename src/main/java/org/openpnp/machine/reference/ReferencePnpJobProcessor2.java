/*
 * Copyright (C) 2011 Jason von Nieda <jason@vonnieda.org>
 * 
 * This file is part of OpenPnP.
 * 
 * OpenPnP is free software: you can redistribute it and/or modify it under the terms of the GNU
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * OpenPnP is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with OpenPnP. If not, see
 * <http://www.gnu.org/licenses/>.
 * 
 * For more information about OpenPnP visit http://openpnp.org
 */

package org.openpnp.machine.reference;

import org.openpnp.model.Job;
import org.openpnp.spi.PnpJobProcessor;
import org.openpnp.spi.base.AbstractJobProcessor;
import org.simpleframework.xml.Root;

@Root
public class ReferencePnpJobProcessor2 extends AbstractJobProcessor implements PnpJobProcessor {
    protected Job job;
    
    public ReferencePnpJobProcessor2() {
    }

    public synchronized void initialize(Job job) throws Exception {
        if (job == null) {
            throw new Exception("Can't initialize with a null Job.");
        }
        this.job = job;
    }

    public synchronized boolean next(Option option) throws JobProcessorException {
        // PreFlight - so what happens if someone adds a placement during a job run? no jobplacement gets created
        // 
        return false;
    }

    public synchronized void abort() throws Exception {
    }
}
