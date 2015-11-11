/*
 * GNU GPL v3 License
 *
 * Copyright 2015 AboutHydrology (Riccardo Rigon)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
