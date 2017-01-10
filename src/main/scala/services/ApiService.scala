package services

import repository.{BookRepository, CategoryRepository}
import akka.http.scaladsl.server.Directives._
import controllers.{BookController, CategoryController}

import scala.concurrent.ExecutionContext


class ApiService(categoryRepository: CategoryRepository, bookRepository: BookRepository)(implicit executor: ExecutionContext) {

  val categoryController = new CategoryController(categoryRepository)

  val bookController = new BookController(bookRepository)

  def routes =
    pathPrefix("api") {
      categoryController.routes ~
      bookController.routes
    }

}
