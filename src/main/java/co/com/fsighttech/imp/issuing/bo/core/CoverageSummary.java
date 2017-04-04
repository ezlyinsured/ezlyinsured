/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.core;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * this object represents a coverage summary for quote process
 * 
 * @author jtorres
 *
 */
@Getter
@Setter
public class CoverageSummary {

    private Long groupCode;
    private Boolean contracted;
    private Integer allCoveragesContracted=new Integer(0);
    private Integer coverageContracted=new Integer(0);
    private Double percentageContracted=new Double(0);
    private Double totalPremiumGroup =new Double(0);
}
