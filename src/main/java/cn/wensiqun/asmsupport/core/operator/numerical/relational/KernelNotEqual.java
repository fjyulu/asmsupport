/**    
 *  Asmsupport is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package cn.wensiqun.asmsupport.core.operator.numerical.relational;

import cn.wensiqun.asmsupport.core.asm.InstructionHelper;
import cn.wensiqun.asmsupport.core.block.ProgramBlockInternal;
import cn.wensiqun.asmsupport.core.definition.KernelParameterized;
import cn.wensiqun.asmsupport.core.operator.Operators;
import cn.wensiqun.asmsupport.org.objectweb.asm.Label;

/**
 * @author 温斯群(Joe Wen)
 *
 */
public class KernelNotEqual extends AbstractNullCompareRelational {

    protected KernelNotEqual(ProgramBlockInternal block, KernelParameterized factor1, KernelParameterized factor2) {
        super(block, factor1, factor2, Operators.NOT_EQUAL_TO);
    }

    @Override
    protected void negativeCmp(Label lbl) {
        this.ifCmp(targetClass.getType(), InstructionHelper.EQ, lbl);
    }

	@Override
	protected void positiveCmp(Label lbl) {
        this.ifCmp(targetClass.getType(), InstructionHelper.NE, lbl);
	}

}
