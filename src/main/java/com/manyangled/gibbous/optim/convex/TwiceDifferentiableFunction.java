/*
Copyright 2018 Erik Erlandson
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.manyangled.gibbous.optim.convex;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;

public abstract class TwiceDifferentiableFunction implements MultivariateFunction {
    public abstract int dim();

    public abstract double value(final RealVector x);
    public abstract RealVector gradient(final RealVector x);
    public abstract RealMatrix hessian(final RealVector x);
    
    public RealVector gradient(final double[] x) {
        return gradient(new ArrayRealVector(x, false));
    }

    public RealMatrix hessian(final double[] x) {
        return hessian(new ArrayRealVector(x, false));
    }

    @Override
    public double value(final double[] x) {
        return value(new ArrayRealVector(x, false));
    }
}