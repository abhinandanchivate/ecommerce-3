import com.infogain.repo.UserRepository
import com.infogain.repo.UserRepositoryImpl
import com.infogain.router.userRoutes
import com.infogain.service.UserService
import com.infogain.service.UserServiceImpl
import io.ktor.server.routing.*


fun Route.rootRoutes(){

    // we need repo object
    val userRepository: UserRepository= UserRepositoryImpl()
    // we need service object
    val userService: UserService = UserServiceImpl(userRepository)

    userRoutes(userService)// service object ===> repo object
}