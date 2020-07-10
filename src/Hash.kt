import com.rsk.security.Argument.argument
import java.io.*
import java.security.MessageDigest
import java.util.*

abstract class SecurityBase(protected val outputStrategy: OutputStrategy) {
    abstract fun run()

    private val overwrite: Boolean by argument()
    private val encode: Boolean by argument()

    @Throws(IOException::class)
    fun createOutputStream(fileName: String): OutputStream {
        return if (fileName.isEmpty())
            System.out
        else {
            val file = File(fileName)

            val fileOutputStream = if (file.exists()) {
                if (overwrite)
                    FileOutputStream(file)
                else
                    throw IOException("Destination file already exists")
            } else {
                FileOutputStream(file)
            }
            fileOutputStream
        }
    }

    @Throws(FileNotFoundException::class)
    fun createInputStream(fileName: String): InputStream {
        return if (fileName.isEmpty())
            System.`in`
        else {
            val f = File(fileName)
            if (f.exists()) {
                FileInputStream(f)
            } else {
                throw FileNotFoundException()
            }
        }
    }


    @Throws(IOException::class)
    fun writeBytes(os: OutputStream, bytes: ByteArray) {
        if (encode) {
            val temp: String
            val encoder = Base64.getEncoder()
            temp = encoder.encodeToString(bytes)
            os.write(temp.toByteArray())
        } else {
            os.write(bytes)
        }
        os.flush()
    }
}


class Hash (outputStrategy: OutputStrategy) : SecurityBase(outputStrategy) {

    private val algorithm: String by argument()
    private val fileName: String by argument()
    private val destFileName: String by argument()
    private val provider: String  by argument()

    class Help {
        fun help() {
            println("usage: java Hash -op 'hash' [-f filename]  [-d destfilename] [-p provider] [-a algorithm] [-o] [-encode]")
            println("\tf filename\t: read input data from filename")
            println("\td destfilename\t: write output hash to destfilename")
            println("\tp provider\t: use specific provider")
            println("\ta algorithm\t: algorithm to use for digest")
            println("\to\t\t: overwrite destfilename file")
            println("\te\t\t: BASE64 encode output")
        }
    }

    init {
        if(algorithm.isEmpty()) throw IllegalArgumentException()
    }

    override fun run() {
        val md = createDigestInstance(algorithm, provider)

        createInputStream(fileName).use { input ->
            createOutputStream(destFileName).use { output ->

                val hashedBytes = digestData(md, input)
                writeBytes(output, hashedBytes)

            }
        }
    }

    private fun digestData(md: MessageDigest, input: InputStream): ByteArray {
        val bytesToHash = input.readBytes()
        md.update(bytesToHash)
        return md.digest()
    }

    private fun createDigestInstance(algorithm: String, provider: String?): MessageDigest {

        return if (provider.isNullOrEmpty()) {
            MessageDigest.getInstance(algorithm)
        } else {
            MessageDigest.getInstance(algorithm, provider)
        }
    }
}