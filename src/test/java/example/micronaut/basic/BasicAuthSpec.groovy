package example.micronaut.basic

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class BasicAuthSpec extends Specification {
    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(embeddedServer)

    def "Verify HTTP Basic Auth works"() {
        when:
        AppClient appClient = embeddedServer.applicationContext.getBean(AppClient)

        then:
        noExceptionThrown()

        when:
        String credsEncoded = "sherlock:password".bytes.encodeBase64().toString()
        String rsp = appClient.home("Basic ${credsEncoded}")
    }
}
