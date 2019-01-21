/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.astro.internal.job;

import static org.openhab.binding.astro.internal.job.Job.checkNull;

import org.openhab.binding.astro.handler.AstroThingHandler;
import org.openhab.binding.astro.internal.AstroHandlerFactory;

/**
 * Scheduled job for planet positions
 *
 * @author Gerhard Riegler - Initial contribution
 * @author Amit Kumar Mondal - Implementation to be compliant with ESH Scheduler
 */
public final class PositionalJob extends AbstractJob {

    /**
     * Constructor
     *
     * @param thingUID thing UID
     * @throws IllegalArgumentException
     *             if the provided argument is {@code null}
     */
    public PositionalJob(String thingUID) {
        super(thingUID);
    }

    @Override
    public void run() {
        AstroThingHandler astroHandler = AstroHandlerFactory.getHandler(getThingUID());
        if (checkNull(astroHandler, "AstroThingHandler is null")) {
            return;
        }
        astroHandler.publishPositionalInfo();
    }

    @Override
    public String toString() {
        return "Positional job " + getThingUID();
    }

}
