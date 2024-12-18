import com.infogain.repo.UserRepository
import com.infogain.repo.UserRepositoryImpl
import com.infogain.router.userRoutes
import com.infogain.service.UserService
import com.infogain.service.UserServiceImpl
import io.ktor.server.routing.*


fun Route.rootRoutes(){


    userRoutes()// service object ===> repo object
}