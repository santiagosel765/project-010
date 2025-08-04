# API Definitions

This document describes the inventory endpoints and DTOs available in this service.

## Category

### DTO `CategoryDTO`
| Field             | Type   | Description                                        |
|-------------------|--------|----------------------------------------------------|
| `id`              | UUID   | Identifier of the category                         |
| `name`            | String | Category name                                      |
| `description`     | String | Optional description                               |
| `parentCategoryId`| UUID   | Identifier of the parent category. `null` for root |
| `status`          | int    | 1 active, 0 disabled                               |

### POST `/v1/inventory/category/save`
Creates or updates a category.

Body: `CategoryDTO`

### POST `/v1/inventory/category/disable`
Disables a category.

Parameters: `id` (UUID)

### GET `/v1/inventory/categories`
Returns a paginated list of categories.

Query parameters:
- `page` – page number (default 0)
- `size` – page size (default 10)

Response: `PageResponse<CategoryDTO>`

---

## Product

### DTO `ProductDTO`
| Field         | Type   | Description                             |
|---------------|--------|-----------------------------------------|
| `id`          | UUID   | Identifier of the product               |
| `name`        | String | Product name                           |
| `description` | String | Description                            |
| `companyId`   | UUID   | Company identifier                      |
| `categoryId`  | UUID   | Category identifier                     |
| `status`      | int    | 1 active, 0 disabled                    |

### POST `/v1/inventory/product/save`
Creates or updates a product.

Body: `ProductDTO`

### POST `/v1/inventory/product/disable`
Disables a product.

Parameters: `id` (UUID)

### GET `/v1/inventory/products`
Returns a paginated list of products.

Query parameters:
- `page` – page number (default 0)
- `size` – page size (default 10)

Response: `PageResponse<ProductDTO>`

---

## Pagination wrapper

### `PageResponse<T>`
Standard wrapper for paginated responses.

| Field          | Type      | Description                         |
|----------------|-----------|-------------------------------------|
| `content`      | List<T>   | Page elements                       |
| `totalPages`   | int       | Total number of pages               |
| `totalElements`| long      | Total number of elements            |
| `currentPage`  | int       | Current page number                 |
| `pageSize`     | int       | Size of the page                    |
