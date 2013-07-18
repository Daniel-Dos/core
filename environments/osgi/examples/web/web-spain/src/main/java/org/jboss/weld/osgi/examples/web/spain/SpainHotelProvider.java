/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.osgi.examples.web.spain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.jboss.weld.environment.osgi.api.annotation.Publish;
import org.jboss.weld.osgi.examples.web.api.Hotel;
import org.jboss.weld.osgi.examples.web.api.HotelProvider;

@Publish
@ApplicationScoped
public class SpainHotelProvider implements HotelProvider {

    private static final String COUNTRY = "Spain";
    private static final Collection<Hotel> hotels = new ArrayList<Hotel>();

    static {
        final String address = "Madrid";
        final String zip = "2222";
        final int hundred = 100;
        int priceMultiplier = 1;

        hotels.add(new Hotel("Catalonia Plaza Mayor", address, COUNTRY, zip, new Double(hundred * priceMultiplier++)));
        hotels.add(new Hotel("emperador", address, COUNTRY, zip, new Double(hundred * priceMultiplier++)));
        hotels.add(new Hotel("Il Castillas hotel", address, COUNTRY, zip, new Double(hundred * priceMultiplier++)));
        hotels.add(new Hotel("Ada Palace", address, COUNTRY, zip, new Double(hundred * priceMultiplier++)));
        hotels.add(new Hotel("Palafox Central Suites", address, COUNTRY, zip, new Double(hundred * priceMultiplier++)));
    }

    @Override
    public Collection<Hotel> hotels() {
        return hotels;
    }

    @Override
    public String getCountry() {
        return COUNTRY;
    }

    @Override
    public boolean book(String id, Date checkin, Date checkout, Integer beds,
            Boolean smocking, String cardNumber, String cardName,
            String cardMonth, String cardYear) {
        return true;
    }
}
