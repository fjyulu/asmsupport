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
package cn.wensiqun.asmsupport.core.operator.numerical.bit;

import cn.wensiqun.asmsupport.core.Parameterized;
import cn.wensiqun.asmsupport.core.block.ProgramBlockInternal;
import cn.wensiqun.asmsupport.core.log.Log;
import cn.wensiqun.asmsupport.core.log.LogFactory;
import cn.wensiqun.asmsupport.core.operator.Operators;

/**
 * 
 * @author 温斯群(Joe Wen)
 *
 */
public class Reverse extends UnaryBitwise {

    private static final Log LOG = LogFactory.getLog(Reverse.class);
    
    protected Reverse(ProgramBlockInternal block, Parameterized factor) {
        super(block, factor);
        this.operator = Operators.REVERSE;
    }

    @Override
    public void doExecute() {
        LOG.print("start inverts operaotr : " + this.operator);
        LOG.print("factor to stack");
        factorToStack();
        LOG.print("start invert");
        insnHelper.inverts(targetClass.getType());
    }

}