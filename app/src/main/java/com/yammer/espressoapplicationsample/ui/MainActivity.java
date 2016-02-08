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
package com.yammer.espressoapplicationsample.ui;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yammer.espressoapplicationsample.ExampleApplication;
import com.yammer.espressoapplicationsample.R;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends DaggerActivity {

    @Bind(R.id.textView)
    TextView textView;

    @Bind(R.id.relativeLayout)
    RelativeLayout relativeLayout;

    @Inject
    ExampleApplication exampleApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (exampleApplication.wasSetupCalled()) {
            textView.setText(R.string.application_insights_setup);
            relativeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.lightRed));
        } else {
            textView.setText(R.string.application_insights_not_setup);
            relativeLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.lightGreen));
        }
    }
}
