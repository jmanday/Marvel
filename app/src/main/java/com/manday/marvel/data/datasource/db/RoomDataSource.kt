package com.manday.marvel.data.datasource.db

class RoomDataSource(
    private val productDao: ProductDao
) : LocalDataSource {

    override suspend fun saveProducts(products: List<Product>) {
        productDao.insertAll(products)
    }

    override suspend fun getProducts(): List<Product> {
        return productDao.getAll()
    }
}