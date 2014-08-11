package org.partialDifferentialEquation;

import org.meshNumericalMethods.unstructuredMesh.adjacencyMatrixBased.AbstractRCAdjacencyMatrixBased;

/*
 This class allows to initialize the object to fill the terms of the
 matrices or arrays of the PDE. The boolean variable matrix has to be set
 true for a matrix term, false for an array term. The function to compute
 every element of an array has to be write inside the method computeArrayTerm.
 Otherwise, the function to compute every element of a matrix has to be write
 inside the method computeMatrixTerm.

 @author: Francesco Serafin - 14 june 2014
 @licence: GPL v 3.0
 */
public abstract class AbstractPdeTerm {

	/*
	 * this variable is true if the derived class is implemented for a matrix,
	 * otherwise it has to be false
	 */
	public boolean matrix;

	/**
	 * this method has to be implemented with the function to compute every term
	 * of an array if the derived class is implemented for an array term
	 *
	 * @param u
	 *            array of unkown variable at the previous time step
	 *
	 * @param mesh
	 *            the object of type AbstractRCAdjacencyMatrixBased
	 *
	 * @param polygonIndex
	 *            the index of the polygon on which the term is computed
	 *
	 *
	 * @return the computed term of the PDE
	 */
	public abstract double computeArrayTerm(double[] u,
			AbstractRCAdjacencyMatrixBased mesh, int polygonIndex);

	/**
	 * this method has to be implemented with the function to compute every term
	 * of a matrix if the derived class is implemented for a matrix term
	 * 
	 *
	 * @param u
	 *            array of unkown variable at the previous time step
	 *
	 * @param mesh
	 *            the object of type AbstractRCAdjacencyMatrixBased
	 *
	 * @param polygonIndex
	 *            the index of the polygon on which the term is computed
	 *
	 * @param sideIndex
	 *            the index of the side shared between the polygon
	 *
	 *            polygonIndex and the adjacent polygon
	 *
	 *
	 * @return the computed term of the PDE
	 */
	public abstract double computeMatrixTerm(double[] u,
			AbstractRCAdjacencyMatrixBased mesh, int polygonIndex, int sideIndex);
	
}
