/*
 * Copyright (C) 2015 Microsoft
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yammer.espressoapplicationsample.module;

import com.yammer.espressoapplicationsample.TestExampleApplication;
import com.yammer.espressoapplicationsample.ApplicationInsightsWrapper;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module(
        injects = {
                TestExampleApplication.class
        },
        complete = false,
        library = true,
        overrides = true)
public class ApplicationInsightsWrapperOverrideModule {
    @Provides
    ApplicationInsightsWrapper provideApplicationInsightsWrapper() {
        return mock(ApplicationInsightsWrapper.class);
    }
}
