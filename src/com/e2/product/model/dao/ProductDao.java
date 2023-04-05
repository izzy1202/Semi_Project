package com.e2.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.e2.common.JDBCTemplate;
import com.e2.product.model.vo.Category;
import com.e2.product.model.vo.PageInfo;
import com.e2.product.model.vo.Product;
import com.e2.product.model.vo.ProductComment;

//상품 DAO - 유원호
public class ProductDao {

	// Properties 객체 생성
	private Properties prop = new Properties();

	// Properties 읽을 수 있게
	public ProductDao() {
		String filePath = ProductDao.class.getResource("/db/sql/product-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 사용자 요청 페이지 상품목록 메소드
	public ArrayList<Product> productSelectList(Connection conn, PageInfo pageInfo, int cNo) {

		// 조회 해 올 상품 list 배열 생성
		ArrayList<Product> list = new ArrayList<Product>();

		ResultSet rSet = null;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("productSelectList");

		// 시작값 = (currentpage -1) * boardLimit+1
		// 끝값 = currentpage * boardLimit
		int startRow = (pageInfo.getCurrentPage() - 1) * pageInfo.getBoardLimit() + 1;
		int endRow = pageInfo.getCurrentPage() * pageInfo.getBoardLimit();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + cNo + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);

			rSet = pstmt.executeQuery();

			while (rSet.next()) {
				Product product = new Product();

				product.setPdPno(rSet.getInt("PRODUCT_NO"));
				product.setPdCno(rSet.getInt("CATEGORY_NO"));
				product.setPdName(rSet.getString("PRODUCT_NAME"));
				product.setPdPrice(rSet.getString("PRODUCT_PRICE"));
				product.setPdDiscount(rSet.getInt("PRODUCT_DISCOUNT"));
				product.setPdCount(rSet.getInt("PRODUCT_COUNT"));
				product.setTitleImg(rSet.getString("TITLEIMG"));

				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(conn);
		}

		return list;
	}

	// 카테고리 목록 조회
	public ArrayList<Category> productSelectCategoryList(Connection conn) {

		ArrayList<Category> list = new ArrayList<Category>();

		PreparedStatement pstmt = null;
		ResultSet rSet = null;

		String sql = prop.getProperty("productSelectCategoryList");

		try {
			pstmt = conn.prepareStatement(sql);
			rSet = pstmt.executeQuery();

			while (rSet.next()) {
				Category category = new Category();

				category.setcNo(rSet.getInt("CATEGORY_NO"));
				category.setcName(rSet.getString("CATEGORY_NAME"));

				list.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	// 베스트 TOP5 조회
	public ArrayList<Product> productTopList(Connection conn) {

		ArrayList<Product> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("productTopList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Product product = new Product();

				product.setPdPno(rset.getInt("PRODUCT_NO"));
				product.setPdName(rset.getString("PRODUCT_NAME"));
				product.setPdPrice(rset.getString("PRODUCT_PRICE"));
				product.setPdDiscount(rset.getInt("PRODUCT_DISCOUNT"));
				product.setTitleImg(rset.getString("TITLEIMG"));

				list.add(product);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	// 상세페이지 상품 조회
	public Product ProductGet(Connection conn, int pNo) {

		ResultSet rSet = null;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("ProductGet");

		Product product = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pNo);

			rSet = pstmt.executeQuery();

			if (rSet.next()) {
				product = new Product();

				product.setPdPno(rSet.getInt("PRODUCT_NO"));
				product.setPdCno(rSet.getInt("CATEGORY_NO"));
				product.setPdCname(rSet.getString("CATEGORY_NAME"));
				product.setPdName(rSet.getString("PRODUCT_NAME"));
				product.setPdPrice(rSet.getString("PRODUCT_PRICE"));
				product.setPdStock(rSet.getInt("PRODUCT_STOCK"));
				product.setPdDiscount(rSet.getInt("PRODUCT_DISCOUNT"));
				product.setPdDesc(rSet.getString("PRODUCT_DESC"));
				product.setPdCount(rSet.getInt("PRODUCT_COUNT"));
				product.setTitleImg(rSet.getString("FILE_PATH") + rSet.getString("SAVE_NAME"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}

		return product;
	}

	// 카테고리별 상품 총 갯수 조회
	public int productSelectListCount(Connection conn, int cNo) {

		int listCount = 0;
		ResultSet rSet = null;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("productSelectListCount");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, "%" + cNo + "%");

			rSet = pstmt.executeQuery();

			if (rSet.next()) {
				// 조회된 게시글 갯수
				listCount = rSet.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}
		return listCount;
	}

	// 상품 조회수 증가 메소드
	public int productIncreaseCount(Connection conn, int pNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("productIncreaseCount");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	// 상세페이지 상품 코맨트 등록
	public int productCmInsert(Connection conn, ProductComment pdCm) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("productCmInsert");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pdCm.getCmName());
			pstmt.setString(2, pdCm.getCmPwd());
			pstmt.setString(3, pdCm.getCmContent());
			pstmt.setInt(4, pdCm.getCmPdNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	// 상세 페이지 상품 코맨트 리스트 조회
	public ArrayList<ProductComment> productCmList(Connection conn, int pNo) {

		ArrayList<ProductComment> list = new ArrayList<ProductComment>();

		PreparedStatement pstmt = null;
		ResultSet rSet = null;

		String sql = prop.getProperty("productCmList");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pNo);

			rSet = pstmt.executeQuery();

			while (rSet.next()) {
				ProductComment productComment = new ProductComment();

				productComment.setCmName(rSet.getString("COMMENT_NAME"));
				productComment.setCmPwd(rSet.getString("COMMNET_PWD"));
				productComment.setCmContent(rSet.getString("COMMENT_CONTENT"));
				productComment.setCmNo(rSet.getInt("COMMENT_NO"));
				productComment.setCmPdNo(rSet.getInt("PD_NO"));
				productComment.setCmStatus(rSet.getString("COMMENT_STAUS"));

				list.add(productComment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			JDBCTemplate.close(rSet);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	// 상세페이지 상품 코맨트 삭제
	public int productCmDelete(Connection conn, int cmNo) {

		int result = 0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("productCmDelete");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cmNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	// 상세페이지 상품 코맨트 갯수 조회
	public int productCmListCount(Connection conn, int pNo) {

		ResultSet rSet = null;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("productCmListCount");

		int count = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, pNo);

			rSet = pstmt.executeQuery();

			if (rSet.next()) {
				count = rSet.getInt("COUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			JDBCTemplate.close(pstmt);
		}

		return count;
	}
	
	//메인 베스트셀러- 이지은
		public ArrayList<Product> MainTopList(Connection conn) {
			ArrayList<Product> list = new ArrayList<>();
			ResultSet rset = null;
			PreparedStatement pstmt = null;

			String sql = prop.getProperty("productTopList");

			try {
				pstmt = conn.prepareStatement(sql);

				rset = pstmt.executeQuery();

				while (rset.next()) {
					Product product = new Product();

					product.setPdPno(rset.getInt("PRODUCT_NO"));
					product.setPdName(rset.getString("PRODUCT_NAME"));
					product.setPdPrice(rset.getString("PRODUCT_PRICE"));
					product.setPdDiscount(rset.getInt("PRODUCT_DISCOUNT"));
					product.setTitleImg(rset.getString("TITLEIMG"));

					list.add(product);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return list;
		}
}
