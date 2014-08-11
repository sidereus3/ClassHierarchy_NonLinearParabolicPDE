package org.partialDifferentialEquation.nonLinearParabolicPDE;

import org.meshNumericalMethods.unstructuredMesh.adjacencyMatrixBased.AbstractRCAdjacencyMatrixBased;
import org.partialDifferentialEquation.AbstractPdeTerm;

/*
 This class allows to building the PDE.
 The methods assembleArray and assembleMatrix are called in the method
 assemblePdeTerm on the basis of the boolean variable matrix.
 The method assemblePdeTerm is called inside the method temporalLoop
 when a term of the PDE has to be assembled.

 @author: Francesco Serafin - 14 june 2014
 @licence: GPL v 3.0
 */
public abstract class AbstractPde {

	/**
	 * This method allows to assemble the arrays of the PDE. The for-loop calls
	 * the method computeArrayTerm to compute the terms of the array one for
	 * each polygon.
	 *
	 * @param u
	 *            array of unkown variable at the previous time step
	 *
	 * @param mesh
	 *            the object of type AbstractRCAdjacencyMatrixBased
	 *
	 * @param pdeTerm
	 *            the object for the term of the PDE
	 *
	 *
	 * @return the filled array of the term of the PDE
	 */
	public double[] assembleArray(double[] u,
			AbstractRCAdjacencyMatrixBased mesh, AbstractPdeTerm pdeTerm) {

		double[] term = new double[mesh.polygonsNumber];

		for (int i = 0; i < mesh.polygonsNumber; i++) {
			term[i] = pdeTerm.computeArrayTerm(u, mesh, i);
		}

		return term;

	}

	/**
	 * This method allows to assemble the matrices of the PDE. The for-loop
	 * cycles through all polygons, the nested for-loop cycles through all the
	 * sides of i-th polygon. The nested loop is written in RC-form.
	 *
	 * @param u
	 *            array of unkown variable at the previous time step
	 *
	 * @param mesh
	 *            the object of type AbstractRCAdjacencyMatrixBased
	 *
	 * @param pdeTerm
	 *            the object for the term of the PDE
	 *
	 *
	 * @return the filled matrix in RC-form of the PDE
	 */
	public double[] assembleMatrix(double[] u,
			AbstractRCAdjacencyMatrixBased mesh, AbstractPdeTerm pdeTerm) {

		double[] term = new double[mesh.Ml.length];

		for (int i = 0; i < mesh.polygonsNumber; i++) {
			for (int j = mesh.Mp[i]; j < mesh.Mp[i + 1]; j++) {
				term[j] = pdeTerm.computeMatrixTerm(u, mesh, i, j);
			}
		}

		return term;

	}

	/**
	 * This method calls the method assembleMatrix or assemblyArray on the basis
	 * of the value of the boolean variable matrix of the object pdeTerm.
	 *
	 * @param u
	 *            array of unkown variable at the previous time step
	 *
	 * @param mesh
	 *            the object of type AbstractRCAdjacencyMatrixBased
	 *
	 * @param pdeTerm
	 *            the object for the term of the PDE
	 *
	 *
	 * @return the filled term of the PDE (matrix or array independently)
	 */
	public double[] assemblePdeTerm(double[] u,
			AbstractRCAdjacencyMatrixBased mesh, AbstractPdeTerm pdeTerm) {

		double[] term;

		if (pdeTerm.matrix) {
			term = assembleMatrix(u, mesh, pdeTerm);
		} else {
			term = assembleArray(u, mesh, pdeTerm);
		}

		return term;

	}

	/**
	 * This method is an abstract one, because the temporal loop has to be
	 * implemented on the basis of the numerical method. 92 93 94
	 *
	 * @param mesh
	 *            the object of type AbstractRCAdjacencyMatrixBased
	 *
	 */
	public abstract void temporalLoop(AbstractRCAdjacencyMatrixBased mesh);

}
