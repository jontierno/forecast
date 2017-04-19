/*
 * Copyright (c) 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not  use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package ar.com.jtierno.solarsystem.api;

import ar.com.jtierno.solarsystem.model.Period;
import ar.com.jtierno.solarsystem.model.SolarSystem;
import com.google.api.server.spi.config.*;

/** The VulcanosAPI API which Endpoints will be exposing. */

@Api(
        name = "vulcanos",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "ar.com.jtierno.solarsystem",
                ownerName = "ar.com.jtierno.solarsystem",
                packagePath=""
        )
)
public class VulcanosAPI {


  // [END echo_method]
  @ApiMethod(name = "forecast", path = "forecast/{day}",httpMethod = "GET")
  public Period getForeCast(@Named("day") Long day) {
    final SolarSystem solarSystem = new SolarSystem();
    return solarSystem.getNextPeriod(day);

  }

}