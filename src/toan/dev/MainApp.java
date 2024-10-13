package toan.dev;

import toan.dev.data.dao.CategoryDao;
import toan.dev.data.dao.Database;
import toan.dev.data.model.Category;
import toan.dev.data.impl.CategoryImpl;
import toan.dev.data.model.Order;
import toan.dev.data.model.OrderItem;
import toan.dev.data.model.Product;
import toan.dev.data.dao.DatabaseDao;
import toan.dev.data.dao.OrderDao;
import toan.dev.data.dao.OrderItemDao;
import toan.dev.data.dao.ProductDao;
import toan.dev.data.dao.UserDao;
import toan.dev.data.impl.UserImpl;
import toan.dev.data.model.User;
import toan.dev.data.seeder.CategorySeeder;
import toan.dev.data.seeder.ProductSeeder;
import toan.dev.data.seeder.UserSeeder;

import java.util.List;
import java.util.Locale;
import com.github.javafaker.Faker;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			DatabaseDao.init(new Database());
			Faker faker = new Faker();
			
			// Lấy đối tượng UserDao thông qua DatabaseDao
	        UserDao userDao = DatabaseDao.getInstance().getUserDao();

	        // Khởi tạo UserSign với UserDao đã lấy được
	        UserSeeder userSign = new UserSeeder(userDao);

	        // Gọi phương thức seedUsers để tạo dữ liệu giả cho bảng user
	        userSign.seedUsers(0);

	        
	        
	        // Category Seeder
	        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
	        CategorySeeder categorySeeder = new CategorySeeder(categoryDao);
	        categorySeeder.seedCategories(0);

	        // Product Seeder
	        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
	        ProductSeeder productSeeder = new ProductSeeder(productDao, categoryDao);
	        productSeeder.seedProducts(2);
	        
	        System.out.println("Seeded fake users successfully!");
			
	}
	
}
