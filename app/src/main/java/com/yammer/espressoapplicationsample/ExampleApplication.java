/**
 * Copyright (c) 2016 Microsoft
 *
 * All rights reserved.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED AS IS, WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package com.yammer.espressoapplicationsample;

import android.app.Application;

import com.yammer.espressoapplicationsample.module.AndroidModule;
import com.yammer.espressoapplicationsample.module.CoreModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class ExampleApplication extends Application {

    private ObjectGraph applicationGraph;

    @Inject
    ApplicationInsightsWrapper applicationInsightsWrapper;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplicationGraph(getModules());
        applicationInsightsWrapper.setup();
    }

    public boolean wasSetupCalled() {
        return applicationInsightsWrapper.wasSetupCalled();
    }

    protected void setApplicationGraph(List<Object> modules) {
        applicationGraph = ObjectGraph.create(modules.toArray());
        applicationGraph.inject(this);
    }

    public void inject(Object object) {
        applicationGraph.inject(object);
    }

    public List<Object> getModules() {
        List<Object> modules = new ArrayList<>();
        modules.add(new AndroidModule(this));
        modules.add(new CoreModule());
        return modules;
    }
}
