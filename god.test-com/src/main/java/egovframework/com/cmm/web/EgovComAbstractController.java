/**
 *
 */
package egovframework.com.cmm.web;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import egovframework.com.cmm.ComDefaultVO;
import lombok.extern.slf4j.Slf4j;

/**
 * EgovComAbstractController.java 클래스
 *
 * @author 이백행
 * @since 2022. 5. 4.
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2022. 5. 4.   이백행        최초 생성
 *      </pre>
 */
@Slf4j
public abstract class EgovComAbstractController {

	@Resource(name = "propertiesService")
	protected EgovPropertyService egovPropertyService;

	protected PaginationInfo builderPaginationInfo(ComDefaultVO comDefaultVO) {
		if (log.isDebugEnabled()) {
			log.debug("comDefaultVO={}", comDefaultVO);
		}

		if (comDefaultVO.getPageUnit() == 10) {
			comDefaultVO.setPageUnit(egovPropertyService.getInt("pageUnit"));
		}
		if (comDefaultVO.getPageSize() == 10) {
			comDefaultVO.setPageSize(egovPropertyService.getInt("pageSize"));
		}

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(comDefaultVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(comDefaultVO.getPageUnit());
		paginationInfo.setPageSize(comDefaultVO.getPageSize());

		comDefaultVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		comDefaultVO.setLastIndex(paginationInfo.getLastRecordIndex());
		comDefaultVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		return paginationInfo;
	}

}