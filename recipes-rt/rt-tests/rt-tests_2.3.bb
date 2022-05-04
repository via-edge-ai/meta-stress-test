SUMMARY = "Real-Time preemption testcases"
HOMEPAGE = "https://wiki.linuxfoundation.org/realtime/documentation/start"
DESCRIPTION = "The main aim of the PREEMPT_RT patch is to minimize the amount of kernel code that is non-preemptible Therefore several substitution mechanisms and new mechanisms are implemented."
SECTION = "tests"
DEPENDS = "linux-libc-headers virtual/libc numactl"
LICENSE = "GPLv2 & GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://git.kernel.org/pub/scm/utils/rt-tests/rt-tests.git;branch=main \
	   file://makefile.patch"
SRCREV = "338843c1ee157ae5d990c6f544f66b447b24fa8b"

S = "${WORKDIR}/git"

# rt-tests needs PI mutex support in libc
COMPATIBLE_HOST_libc-musl = 'null'

# Do not install hwlatdetect
EXTRA_OEMAKE += "PYLIB=''"

do_install() {
        oe_runmake install DESTDIR=${D} SBINDIR=${sbindir} MANDIR=${mandir} \
                           INCLUDEDIR=${includedir}
}

RDEPENDS:${PN} = "numactl bash"
