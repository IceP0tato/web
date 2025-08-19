package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.ProductDao;
import web.model.dto.ProductDto;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public int createProduct(ProductDto productDto) {
        return productDao.createProduct(productDto);
    }

    public boolean createProductImage(int pno, String fileName) {
        return productDao.createProductImage(pno, fileName);
    }

    public List<ProductDto> getAllProduct() {
        // 모든 제품의 정보 조회
        List<ProductDto> productDtoList = productDao.getAllProduct();
        // 모든 제품의 이미지 조회 (dto와 list의 주소값이 같아서 내용이 변하면 리스트도 같이 변함)
        for (ProductDto productDto : productDtoList) {
            List<String> images = productDao.getProductImages(productDto.getPno());
            productDto.setImages(images);
        }
        return productDtoList;
    }

    public List<String> getProductImages(int pno) {
        return productDao.getProductImages(pno);
    }

    public ProductDto getProduct(int pno) {
        // 특정 제품 조회
        ProductDto productDto = productDao.getProduct(pno);
        // 특정 제품 이미지명 조회
        if (productDto != null) {
            List<String> images = productDao.getProductImages(productDto.getPno());
            productDto.setImages(images);
        }
        return productDto;
    }
}
