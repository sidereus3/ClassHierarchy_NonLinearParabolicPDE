package org.partialDifferentialEquation.solver;

import cern.colt.matrix.tdouble.algo.solver.IterativeSolverDoubleNotConvergedException;
import cern.colt.matrix.tdouble.impl.DenseDoubleMatrix1D;
import cern.colt.matrix.tdouble.impl.SparseRCDoubleMatrix2D;

public interface RowCompressedConjugateGradient {

	// PRECONDITIONERS
	// public void cgAMG_preonditioner(int equationNumber,
	// SparseRCDoubleMatrix2D A);

	public void cgDoubleDiagonal_preconditioner(int equationNumber,
			SparseRCDoubleMatrix2D A);

	public void cgICC_preconditioner(int equationNumber,
			SparseRCDoubleMatrix2D A);

	// public void cgIdentity_preconditioner(int equationNumber,
	// SparseRCDoubleMatrix2D A);

	public void cgILU_preconditioner(int equationNumber,
			SparseRCDoubleMatrix2D A);

	public void cgILUT_preconditioner(int equationNumber,
			SparseRCDoubleMatrix2D A);

	public void cgSSOR_preconditioner(int equationNumber,
			SparseRCDoubleMatrix2D A);

	// CONJUGATE GRADIENT SOLVER
	public void cgSolver(DenseDoubleMatrix1D b, SparseRCDoubleMatrix2D A)
			throws IterativeSolverDoubleNotConvergedException;

}
