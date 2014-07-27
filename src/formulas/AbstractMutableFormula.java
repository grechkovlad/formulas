package formulas;

import formulas.evolutionary.FormulaVisitor;

public abstract class AbstractMutableFormula implements Formula, Cloneable {

	protected int subtreeSize;

	public abstract AbstractMutableFormula accept(FormulaVisitor visitor);

	public int getSubtreeSize() {
		return subtreeSize;
	}

	public abstract AbstractMutableFormula clone();
}
