/**
 * 
 */
package co.com.fsighttech.imp.issuing.bo.core;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * this class represents a group for a set of coverage
 * 
 * @author jtorres
 *
 */
@Setter
@Getter
@EqualsAndHashCode(of={"name","code"})
public class CoverageGroup {

	private Long id;
	private String name;
	private Long code;
	private Long parentCode;
	private String level;
	private Integer coveragesContracted;
	private Integer sequence;
	private List<Coverage> coverages;
	private Boolean real;
}
